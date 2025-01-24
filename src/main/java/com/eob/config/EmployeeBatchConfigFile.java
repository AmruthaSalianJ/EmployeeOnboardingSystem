package com.eob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.eob.entity.User;
import com.eob.exception.ExceptionSkipPolicy;
import com.eob.repository.UserRepo;

@Configuration
public class EmployeeBatchConfigFile { 

    @Value("${file.input}")
    private String source; 

    @Autowired
    private UserRepo userRepo;

    // FlatFileItemReader
    @Bean
     FlatFileItemReader<User> userItemReader() {
        return new FlatFileItemReaderBuilder<User>()
                .name("userItemReader")
                .resource(new ClassPathResource(source))
                .linesToSkip(1)
                .delimited()
                .names(new String[] {"email","password_hash","username"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(User.class);
                }})
                .build();
    }

    @Bean
    public BatchProcessor createItemProcessor() {
        return new BatchProcessor();
    }

    @Bean
    public RepositoryItemWriter<User> productWriter() {
        RepositoryItemWriter<User> repositoryItemWriter = new RepositoryItemWriter<>();
        repositoryItemWriter.setRepository(userRepo);
        repositoryItemWriter.setMethodName("save");
        return repositoryItemWriter;
    }

    // Step creation
    @Bean
    public Step stepProduct(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("stepProduct", jobRepository)
                .<User, User>chunk(10, transactionManager)
                .reader(userItemReader())
                .processor(createItemProcessor())
                .writer(productWriter())
                .faultTolerant()
                .skip(RuntimeException.class) // skip specific exceptions
                .skipLimit(5)
                .build();
    }

    @Bean
    public Job userJob(JobRepository jobRepository, @Qualifier("stepProduct") Step step1) {
        return new JobBuilder("userJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1) // Using the correct Step here
                .build();
    }

    @Bean
    public SkipPolicy skipPolicy() {
        return new ExceptionSkipPolicy();
    }

    @Bean
    public SkipListener skipListener() {
        return new StepSkipListener();
    }
}

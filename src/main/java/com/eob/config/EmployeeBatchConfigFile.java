package com.eob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.PartitionStepBuilder;
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
@EnableBatchProcessing
public class EmployeeBatchConfigFile {
 
	@Value("${file.input}")
	private String source;
	
	@Autowired
	UserRepo userRepo;
	
	// FlatFileItemReader
	@Bean
	FlatFileItemReader<User> userItemReader() {
		
		return new FlatFileItemReaderBuilder<User>().name("productItemReader")
				.resource(new ClassPathResource(source))
				.linesToSkip(1)
				.delimited()
				.names(new String[] {"userId","username","passwordHash","email"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
					setTargetType(User.class);
				}})
				.build();
	}
	
	
	@Bean
	BatchProcessor createItemProcessor()
	{
		return new BatchProcessor();
	}
	
	@Bean
	RepositoryItemWriter<User> productWriter()
	{
		RepositoryItemWriter<User> repositoryItemWriter = new RepositoryItemWriter<>();
		
		repositoryItemWriter.setRepository(userRepo);
		repositoryItemWriter.setMethodName("save");
		return repositoryItemWriter;
	}
		
	
	//Step creation
	
//	@Bean
//	Step stepProduct(JobRepository jobRepository, PlatformTransactionManager transactionManager)
//	{
//		var step = new StepBuilder("stepProduct", jobRepository)
//				.<Product,Product>chunk(10,transactionManager)
//				.reader(productItemReader())
//				.processor(createItemProcessor())
//				.writer(productWriter())
//				.build();
//		return step;
//		
//	}
//	
	
	
	@Bean
	Job productJob(JobRepository jobRepository, @Qualifier("stepProduct")Step step1)
	{
		return new JobBuilder("productJob",jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(step1)
				//.next(step2)
				.build();
	}
	
	@Bean
	Step stepProduct(JobRepository jobRepository, PlatformTransactionManager transactionManager)
	{
		var step = new StepBuilder("stepProduct", jobRepository)
				.<User,User>chunk(10,transactionManager)
				.reader(userItemReader())
				.processor(createItemProcessor())
				.writer(productWriter())
				.faultTolerant()
				.skip(RuntimeException.class) // skip specific exceptions
				.skipLimit(5) //
				.build();
		return step;
		
		/*
		 * var step = new StepBuilder("stepProduct", jobRepository)
		 * .<Product,Product>chunk(10,transactionManager) .reader(productItemReader())
		 * .processor(createItemProcessor()) .writer(productWriter()) .faultTolerant()
		 * //.skip(RuntimeException.class) // skip specific exceptions //.skipLimit(5)
		 * // .listener(skipListener()) .skipPolicy(skipPolicy()) .build();
		 */
		
	}
	@Bean
	SkipPolicy skipPolicy() {
		return new ExceptionSkipPolicy();
	}
	

	 
	@Bean
	SkipListener skipListener() {
	return new StepSkipListener();
	}

	@Bean
	PartitionHandler partitionHandler() {
		return new TaskExecutorPartitionHandler();
	}
	
	
	/*
	 * @Bean Partitioner partitioner() { return new CustomPartitioner(); }
	 */
}

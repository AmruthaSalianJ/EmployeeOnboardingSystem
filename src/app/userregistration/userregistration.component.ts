import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-userregistration',
  imports: [CommonModule, ReactiveFormsModule],  
  standalone:true,
  templateUrl: './userregistration.component.html',
  styleUrl: './userregistration.component.css'
})

export class UserregistrationComponent {
  registrationForm: FormGroup;
  selectedFile: File | null = null;

  constructor(private fb: FormBuilder) {
    // Initialize the form with validations
    this.registrationForm = this.fb.group({
      name: ['', [Validators.required]],  // Name is required
      email: ['', [Validators.required, Validators.email]],  // Email is required and must be valid
      document: [null, [Validators.required]]  // Document is required
    });
  }

  // Handle file selection
  onFileChange(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
      this.registrationForm.get('document')?.setValue(file);
    }
  }

  // Submit form data
  onSubmit(): void {
    if (this.registrationForm.valid) {
      const formData = new FormData();
      formData.append('name', this.registrationForm.get('name')?.value);
      formData.append('email', this.registrationForm.get('email')?.value);
      formData.append('document', this.selectedFile!);

      // Send the form data to the backend (example URL)
      // this.http.post('http://localhost:8080/api/register', formData).subscribe(response => {
      //   console.log(response);
      // });

      console.log('Form Submitted', formData);
    }
  }
}

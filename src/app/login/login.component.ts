import { Component } from '@angular/core';

import { FormBuilder, FormGroup, Validators,ReactiveFormsModule } from '@angular/forms';

import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';




@Component({

  selector: 'app-login',

  templateUrl: './login.component.html',

  styleUrls: ['./login.component.css'],

  standalone:true,

  imports: [CommonModule,ReactiveFormsModule]


})

export class LoginComponent {

  loginForm: FormGroup;

  errorMessage: string = '';



  constructor(private fb: FormBuilder, private http: HttpClient) {

    this.loginForm = this.fb.group({

      username: ['', Validators.required],

      password: ['', Validators.required]

    });

  }



  onSubmit() {

    if (this.loginForm.valid) {

      this.http.post('http://localhost:8080/api/auth/login', this.loginForm.value)
      .subscribe({

        next: (response) => alert('Login successful'),
        error:(err)=> this.errorMessage='Invalid credentials'
       


        });

     
    }

  }

}
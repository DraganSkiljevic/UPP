import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder, NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/User';
import { UserService } from '../services/user-service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = this.formBuilder.group({username: ['', Validators.required],
                                      password: ['', [Validators.required,
                                                    Validators.minLength(2),
                                                    Validators.maxLength(50)]] });

  loginError = '';
  username : string=""; 
  password : string="";
  sendUser: User = new User();

  constructor(private route: ActivatedRoute, private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit() {
  }
  login() {
    //const username = submittedForm.get('username').value;
    //const password = submittedForm.get('password').value;
    this.sendUser.username = this.username;
    this.sendUser.password = this.password;
    console.log('u login btn je  ' + this.username + ', ' + this.password);
    let x = this.userService.loginUser(this.sendUser);
    console.log('Pre subscribe');
    x.subscribe(
      res => {
        console.log(res);
        alert('Successfully logged in!');
        sessionStorage.setItem('loggedUser', JSON.stringify(res));
        window.location.href = '/homepage';
      },
      err => {
        console.log('Username or password are not correct!');
      }
    );
  }
}

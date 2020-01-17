import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user-service/user.service';
import { RepositoryService } from '../services/repository-service/repository.service';
import { User } from '../model/User';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  private formFieldsDto = null;
  private formFields = [];
  private processInstance = '';
  private tasks = [];
  private user: User;
  private type = '';
  constructor(private userService: UserService, private repositoryService: RepositoryService) {
    this.user  = JSON.parse(sessionStorage.getItem('loggedUser'));
    console.log('user je ');
    console.log(this.user);
    console.log('username' + this.user.username);
    this.type = this.user.type;
    let x = this.repositoryService.getTasksOfUser(this.user.username);

    x.subscribe(
      res => {
        console.log(res);
        this.tasks = res;
      },
      err => {
        console.log('Error occured');
      }
    );
   }

  ngOnInit() {

  }
  magForm() {
    window.location.href = 'newMagazine';
  }
  complete(taskId){
    let x = this.repositoryService.completeTask(taskId);
    console.log('Usao u complete task');
   
   }
  logoutFunc() {
    let x =  this.userService.logoutUser();
    x.subscribe(
      res => {
        sessionStorage.setItem('loggedUser', null);
        window.location.href = 'login';
      },
      err => {
        console.log('Mistake!');
      }
    );
}
}

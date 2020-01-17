import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user-service/user.service';
import { RepositoryService } from '../services/repository-service/repository.service';
import { AreaService } from '../services/areas-service/area.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];

  constructor(private userService: UserService, private areaService: AreaService, private repositoryService: RepositoryService) {

    repositoryService.startProcess().subscribe(
      res => {
        this.formFieldsDto = res;
        this.formFields = res.formFields;
        this.areaService.loadAreas().subscribe(
          res => {
            this.categories = res;
           }
        );
      },
      err => {
        console.log('Error occured');
      }
    );
  }

  ngOnInit() {
  }

  onSubmit(value, form) {
    const o = new Array();
    for (const property in value) {
      o.push({fieldId : property, fieldValue : value[property]});
    }
    let cat= new Array();
       for(let a of this.categories){
          if (a.isChecked)
            cat.push(a.id);
       }
    o.push({fieldId : "branches", categories : cat});
    this.userService.registerUser(o, this.formFieldsDto.taskId).subscribe(
      res => {
        alert('You registered successfully!');
        window.location.href = 'login';
      },
      err => {
        console.log('Error occured');
      }
    );
  }
}

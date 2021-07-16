import { Component, OnInit } from '@angular/core';
import { User } from './models/user';
import { UserService } from './services/user.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'userManagerApp';
  usersList: User[];

  userForm: FormGroup;
  constructor(private userService: UserService, private fb: FormBuilder, private modalService: NgbModal) {
  }

  ngOnInit() {
    this.getUsers();

    this.userForm = this.fb.group({
      nom: '',
      prenom: '',
      phone: '',
      email: '',
    });
  }

  getUsers() {
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.usersList = response;
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
  }

  addUser() {
    this.userService.addUser(this.userForm.value as User).subscribe(
      () => {
        this.getUsers();
        this.userForm.reset();
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        this.userForm.reset();
      }
    );
  }
  open(content: any): void {
    this.modalService.open(content)
  }
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
<<<<<<< HEAD
import { NgbAlertModule, NgbDatepickerModule, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { JsonPipe } from '@angular/common';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    imports: [CommonModule, RouterOutlet,NgbDatepickerModule, NgbAlertModule, FormsModule, JsonPipe]
=======
import { ContainerComponent } from './container/container.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ContainerComponent ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
>>>>>>> main
})
export class AppComponent {
  title = 'itinerease-client';
  dataStartModel!: NgbDateStruct;
  dateEndModel!: NgbDateStruct;
}





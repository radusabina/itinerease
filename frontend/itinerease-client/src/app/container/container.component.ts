import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalsComponent } from '../modals/modals.component';

@Component({
    selector: 'app-container',
    standalone: true,
    imports: [CommonModule, ModalsComponent],
    templateUrl: './container.component.html',
    styleUrl: './container.component.scss',
})
export class ContainerComponent {}

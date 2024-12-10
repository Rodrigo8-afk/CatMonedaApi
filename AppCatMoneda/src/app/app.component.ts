import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Administrador tabla  HU_CAT_MONEDA';

   //Inyectar dependencias 
   constructor(private router: Router){}

   Listar(){
    this.router.navigate(['listar'])
   }

   NuevoRegistro(){
    this.router.navigate(['guardar'])
   }
}

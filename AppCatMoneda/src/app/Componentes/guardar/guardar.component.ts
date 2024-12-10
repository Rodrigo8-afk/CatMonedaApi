import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { WsCatMonedaService } from '../../Servicios/ws-cat-moneda.service';
import { Router } from '@angular/router';
import { CatMoneda } from '../../Entidades/CatMoneda';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './guardar.component.html',
  styleUrl: './guardar.component.css'
})
export class GuardarComponent {
  constructor(private service: WsCatMonedaService,
    private router: Router
 ){}

 catMoneda: CatMoneda = new CatMoneda();

 
 guardar(){
   this.service.guardar(this.catMoneda).subscribe({
     next:() => {
       Swal.fire({
         title:'Guardado',
         text:'Se guardo exitosamente la informacion'
     });
     this.router.navigate(['listar']);
     },
     error:err =>{
       console.error(JSON.stringify(err));
     }
   });
 }
}

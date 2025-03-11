import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { enquiry } from '../../model/enquiry';

@Component({
  selector: 'app-enquiries',
  templateUrl: './enquiries.component.html',
  styleUrl: './enquiries.component.css'
})
export class EnquiriesComponent {
  enquirylist: enquiry[] = [];

  serviceTypes: string[] = [
     'All',
     'Product Design and Development',
     'Automation and Control Systems',
     'Structural Engineering Solutions',
     'Electrical and Electronics Engineering',
     'Systems Integration',
     'Research and Development (R&D)'
    ];

    selected:string='All';	

  constructor(private api:ApiService){

  }

  ngOnInit(){ 
     this.api.getEnquiries().subscribe({
       next: (response:enquiry[]) => {
         this.enquirylist = response;
       },
       error: (error) => {
         console.log("Error while fetching enquiries", error);
       }
  })
}
}
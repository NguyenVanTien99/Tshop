import { Component, Input, OnInit, TemplateRef } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/shared/models/product';
import { Rate } from 'src/app/shared/models/rate';
import { User } from 'src/app/shared/models/user';
import { RateService } from 'src/app/shared/services/rate.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styleUrls: ['./rate.component.css']
})
export class RateComponent implements OnInit {

  star:number=5;
  comment:string;
  rate:Rate;
  user:User;

  @Input() product :Product;


  constructor(private modalService: NgbModal, private tokenStorageService: TokenStorageService, private rateService: RateService, private toastr: ToastrService) { }

  ngOnInit(): void {

  }

  open(content: TemplateRef<any>) {
    this.modalService.open(content, {centered: true})
  }

  rating() {

    this.user = this.tokenStorageService.getUser();

    let _user = new User();

    _user.id = this.user.id

    console.log(_user);
    
    
    this.rate = new Rate(0, this.star, this.comment, this.product.id , _user);

    console.log(this.rate);
    

    this.rateService.saveRate(this.rate).subscribe(data=>{
      this.toastr.success('Đánh giá thành công!', 'Hệ thống');
      this.modalService.dismissAll();
    })
    
  }

}

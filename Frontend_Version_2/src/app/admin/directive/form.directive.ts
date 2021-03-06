import { Directive, ElementRef, HostListener } from "@angular/core";

@Directive({
    selector: '[focusInvalidInput]'
  })
  export class FormDirective {
    constructor(private el: ElementRef) { }
  
    @HostListener('submit')
    onFormSubmit() {

      console.log("@HostListener('submit')");

      const invalidControl = this.el.nativeElement.querySelector('.ng-invalid');

      console.log(invalidControl);
      
  
      if (invalidControl) {
        invalidControl.focus();  
      }
    }
  }
import { FormControl, FormGroup } from '@angular/forms';

export default class FormUtils {

  static isFieldInvalid(form: FormGroup, field: string) {
    const  formField = form.get(field);
    return !formField.valid && formField.touched;
  }

  static displayFieldCss(form: FormGroup, field: string) {
    return {
      'has-error': FormUtils.isFieldInvalid(form, field),
      'has-feedback': FormUtils.isFieldInvalid(form, field)
    };
  }

  static validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      console.log(field);
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }
}


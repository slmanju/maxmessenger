export class Role {
  code: string;
  name: string;
  id?: string;

  constructor(code: string,
              name: string,
              id?: string) {
      this.code = code;
      this.name = name;
      this.id = id;
  }

}

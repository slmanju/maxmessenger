export class Message {
  text: string;
  author?: string;
  id?: string;
  date?: string;

  constructor(text: string, author?: string, id?: string, date?: string) {
      this.text = text;
      this.author = author;
      this.id = id;
      this.date = date;
  }

}

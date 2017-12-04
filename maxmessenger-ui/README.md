

# Angular 5 Bootstrap 3 Starter 
based on https://loiane.com/2017/08/how-to-add-bootstrap-to-an-angular-cli-project/

Step 1. ng new angular-bootstrap-example

Step 2. npm install bootstrap --save

Step 3. @import '~bootstrap/dist/css/bootstrap.min.css'; in src/style.css

Step 4. npm install ngx-bootstrap --save

Step 5. Import modules



## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

`ng generate component component-name`
  ng generate component messages --module app
`ng generate directive|pipe|service|class|guard|interface|enum|module`.
`ng generate module app-routing --flat --module=app`
--flat puts the file in src/app instead of its own folder.
--module=app tells the CLI to register it in the imports array of the AppModule.

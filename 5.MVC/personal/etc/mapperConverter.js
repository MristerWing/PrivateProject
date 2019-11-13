const str = "employee_id first_name hire_date job_id salary department_id department_name";

const a = str.split(" ");
const converter = a.reduce((s, x) => s + "#{" + x + "}" + ", ", "");

console.log(converter);
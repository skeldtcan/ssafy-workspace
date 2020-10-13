-- 1)
select e.first_name, e.department_id, d.department_name
from employees e join departments d
where e.department_id = d.department_id
and e.department_id=30;

-- 2)
select 
	distinct (select j.job_title from jobs j where e.job_id = j.job_id) as job_title,
	(select l.city from locations l where d.location_id = l.location_id) as location
from employees e  left join departments d
using (department_id)
where e.department_id=30;

-- 3)
select e.first_name, d.department_name,
	(select l.city from locations l where d.location_id = l.location_id) as location
from employees e  left join departments d
using (department_id)
where e.commission_pct is not null;

-- 4)
select e.first_name, d.department_name
from employees e  left join departments d
using (department_id)
where e.first_name like '%a%'
or e.first_name like '%A%';

-- 5)
select e.first_name,
	(select j.job_title from jobs j where e.job_id = j.job_id) as job_title,
    d.department_id, d.department_name
from employees e left join departments d
using (department_id)
where d.location_id = (select l.location_id from locations l where l.city = 'Dallas');

-- 6)
select e.first_name as 'employee', e.employee_id as 'emp#' , m.first_name as 'manager', m.employee_id as 'mgr#'
from employees e inner join employees m
on e.manager_id = m.employee_id;

-- 7)
select e.first_name, 
	(select j.job_title from jobs j where e.job_id = j.job_id) as job_title,
    (select d.department_name from departments d where e.department_id = d.department_id) as department,
    e.salary, s.grade
from employees e join salgrades s
where e.salary between s.losal and s.hisal;

-- 8)
select *
from employees e
where e.hire_date > (select e.hire_date from employees e where e.first_name = 'Smith');

-- 9)

-- 10)

-- 11)

-- 12)

-- 13)

-- 14)

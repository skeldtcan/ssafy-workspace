-- 1)
select e.employee_id, e.first_name, e.job_id, e.department_id,
		(select d.department_name from departments d where e.department_id = d.department_id)
from employees e
where e.job_id = (	select e.job_id
                    from employees e
                    where e.first_name = 'Diana'
				);
                
-- 2)
select e.employee_id, e.first_name,
	(
		select j.job_title
		from jobs j
		where e.job_id = j.job_id
	) as job_title,
    (
		select d.department_name
		from departments d
		where e.department_id = d.department_id
	) as department_name
from (
		select *
		from employees
        where manager_id = 	(
								select manager_id 
								from employees
								where first_name='Bruce'
							)
	) e;
	
        
        
-- 3)
set @pageno = 2;

select b.employee_id, b.first_name, b.hire_date
from ( 
		select @rownum := @rownum + 1 as rn, a.*
		from (
				select employee_id, first_name, hire_date
                from employees
                order by hire_date
			) a, (select @rownum := 0) tmp
	) b
where b.rn > (@pageno * 5 - 5) and b.rn <= (@pageno * 5);

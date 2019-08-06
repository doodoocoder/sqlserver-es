pageQuery
===
  select * from tb_ba_jbxx where  State="1"
  
pageQuery$count
===
   select count(1) from tb_ba_jbxx where State="1"

matchQuery
===
  select * from tb_ba_jbxx where  State="1" and xm like #"%"+xm+"%"#
  
matchQuery$count
===
  select count(1) from tb_ba_jbxx where State="1" and xm like #"%"+xm+"%"#

delete
===
   update tb_ba_jbxx set State="-1" where BAJBXXID=#bajbxxid#  
  
listAll
===
   select * from tb_ba_jbxx
   
   
 

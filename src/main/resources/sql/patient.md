save
===
  insert into "VZ"."Patient"("id","Pat_Name","Pat_Birth","Pat_Addr","Pat_Nation","Pat_Phone","Pat_Marri","Pat_Fam","Pat_Height","Pat_Weight","Pat_Card","State")values(#patId#,#patName#,#patBirth#,#patAddr#,#patNation#,#patPhone#,#patMarri#,#patFam#,#patHeight#,#patWeight#,#patCard#,#state#)

pageQuery
===
  select * from "VZ"."Patient" where  "State"='1'
  
pageQuery$count
===
   select count(1) from "VZ"."Patient" where "State"='1'

matchQuery
===
  select * from "VZ"."Patient" where  "State"='1' and "Pat_Name" like #"%"+patName+"%"#
  
matchQuery$count
===
  select count(1) from "VZ"."Patient" where "State"='1' and "Pat_Name" like #"%"+patName+"%"#

delete
===
   update "VZ"."Patient" set "State"='-1' where "id"=#patId#  
   
update
====
  update "VZ"."Patient" set 
  
  "Pat_Name" = #patName#,
       
 
  "Pat_Birth" = #patBirth#,
                  
  
   "Pat_Addr" = #patAddr#,
           
  
   "Pat_Nation" = #patNation#,
          
  
   "Pat_Phone" = #patPhone#,
          
   
   "Pat_Marri" = #patMarri#,
           
   
   "Pat_Fam" = #patFam#,
           
   
   "Pat_Height" = #patHeight#,
        
   
   "Pat_Weight" = #patWeight#,
  
   "Pat_Card" = #patCard#
             
                                               
   where "id"=#patId#
   
 

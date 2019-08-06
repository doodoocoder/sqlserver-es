listAll
===
   select top 1 * from MessageLogs where id='00000B4A-9B71-4BF0-90FB-0C0DE8D25C43' order by  createtime
   
getAllPrimaryKey
===
   select id from Messagelogs order by createtime
   
getBatchEntity
===
   select * from Messagelogs where id in ( #join(ids)#)
   
getBatch
===
   select top 500 * from Messagelogs where isReply !=4 or isReply is null order by createtime
   
updateBatchById
===
   update Messagelogs set isReply=4 where id =#id#

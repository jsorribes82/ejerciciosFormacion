create or replace package pack_ex as
    procedure xxx(fecha date);
    function avui return date;
    
end pack_ex;
commit;

create or replace package body pack_ex as
    begin
    function avui return date is
      begin
      return sysdate;
      end;
    procedure xxx (fecha date) as
      begin
        avui:=sysdate;
        dbms_output.put_line(avui);
      end;
   end; 
end pack_ex;

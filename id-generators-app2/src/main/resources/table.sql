1. Generator Type - Sequence:

CREATE table "EMPLOYEES" (
    "ID"         NUMBER,
    "NAME"       VARCHAR2(20),
    constraint  "EMPLOYEES_PK" primary key ("ID")
)
/

CREATE sequence "EMPLOYEES_SEQ" 
/

CREATE trigger "BI_EMPLOYEES"  
  before insert on "EMPLOYEES"              
  for each row 
begin  
  if :NEW."ID" is null then
    select "EMPLOYEES_SEQ".nextval into :NEW."ID" from dual;
  end if;
end;
/   

------------------------------------------------------------------------------------------------
2. Generator Type - Table: (Don't populate primary key from sequance)

CREATE TABLE ID_GEN 
(
  GEN_NAME VARCHAR2(60) NOT NULL 
, GEN_VALUE INT 
, CONSTRAINT ID_GEN_PK PRIMARY KEY (GEN_NAME) ENABLE 
);


CREATE table "EMPLOYEES" (
    "ID"         NUMBER,
    "NAME"       VARCHAR2(20),
    constraint  "EMPLOYEES_PK" primary key ("ID")
)
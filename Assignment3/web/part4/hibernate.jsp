
set(not allow duplicate)
<set name=“images” table=“item_image”> 
<key column=“item_id”>
<element type=“String” column=“filename” not-null=“true”/> 
</set>

idbag(allow dupllicate)
<idbag name=“images” table=“item_image” >
<collection-id type=“long” column=“item_image_id”>
<generator class=“sequence”>
</collection-id>
<key column=“item_id”>
<element type=“String” column=“filename” not-null=“true”> 
</idbag>

list(not allow duplicate)
<list name=“images” table=“item_iamge”> 
<key column=“item_id”>
<list_index column=“position”/>
<element type=“string” name=“filename” not-null=“true”> 
</list>

map(allow duplicate)
<map name=“images” table=“item_iamge” order-by=“filename”desc> 
<key-column=“item_id”>
<map-key column=“image_name” type=“String”>
<element type=“String” name=“filename” not-null=“true”>
</map>
#or sort=“natural”


Class Student{
    int id;
    String name;
    //get setter
}
Class Address{
    int id;
    String address;
    //get setter
}
one to one
/*
1.give same primary key
2.using a foreign key constraint from one table onto a unique identifier column of the other
*/
<hibernate-mapping>
<class name="Student" table="STUDENT">
    <id name="id" type="int">
       <column name="id"/>
       <generator class="native">
    </id>
    <property name="name" typr="String">
       <column name="name"/>
    </property>
    <one-to-one name="address" class="Address" cascade="all"/>
</class>
</hibernate-mapping>

<hibernate-mapping>
    <class name="Address" table="ADDRESS">
        <id name="id" type="int">
            <column nname="id"/>
            <generator class="native"/>
        </id>
        <one-to-one name="student" class="Student" constrained="true"/>
        <property name="address" type="String">
            <column name="address"/>
        </property>
    </class>
</hibernate-mapping>

one to many
/*
1. “many” class has a foreign key into the (usually primary) unique key of the “one” class.
2. link table contains the foreign keys referencing the two tables
3. the one-to-many attributes has to be in collection <key> mapping 
*/
Class Student{
    int id;
    String name;
    List<Address> stuadd=new ArrayList<Student>();
    //get setter
}
Class Address{
    int id;
    String address;
    //get setter
}
<hibernate-mapping>
        <class name="Student" table="STUDENT">
            <id name="id" type="int">
               <column name="id"/>
               <generator class="native">
            </id>
            <property name="name" typr="String">
               <column name="name"/>
            </property>
            <list name="stuadd" table="STUADD" inverse="true">
                <key coulumn="id" not-null="true"/>
                <list-index column="   "/>
                <one-to-many class="Address"/>
            </list>
        </class>
</hibernate-mapping>

<hibernate-mapping>
        <class name="Address" table="ADDRESS">
            <id name="id" type="int">
                <column nname="id"/>
                <generator class="native"/>
            </id>
            <property name="address" type="String">
                <column name="address"/>
            </property>
        </class>
</hibernate-mapping>

bidirection mapping
/*
1.bidirection one-side in collection inverse="true"
2.many-side <many-to-one name="" column="" not-null="true" insert="false" update="false">
2. one-to-many
   many-to-one

*/
one-side
<hibernate-mapping>
        <class name="Student" table="STUDENT">
            <id name="id" type="int">
               <column name="id"/>
               <generator class="native">
            </id>
            <property name="name" typr="String">
               <column name="name"/>
            </property>
            <list name="stuadd" table="STUADD" inverse="true">
                <key coulumn="id" not-null="true"/>
                <list-index column="   "/>
                <one-to-many class="Address"/>
            </list>
        </class>
</hibernate-mapping>

many-side
<hibernate-mapping>
    <class name="Addresss" table="ADDRESS">
        <id name="id" type="int">
            <column name="id"/>
            <generator class="native"/>
        </id>
        <property name="address" type="String">
            <column name="address"/>
        </property>
        <many-to-one name="student" cloumn="id" class="Studnet" not-null="true" insert="false" update="false"/>
    </class>
</hibernate-mapping>



bidirection many-to-many
/*
1.in both collections cascade="save-update"
2.on end must clair inverse="true" 
*/
<class name="Student">
    ....
    <set name="stu" table="STU_ADD" inverse="true" cascade="save-update">
        <key column="id"/>
        <many-to-many class="Address" column="id"/>
    </set>
</class>

<class name="Address">
        ....
        <set name="adds" table="STU_ADD" cascade="save-update">
            <key column="id"/>
            <many-to-many class="Student" column="id"/>
        </set>
</class>


using the <union-subclass/> Interitance Strategy

<hibernate-mapping>
    <class name="Student" abtract="true">
        <id name="id" type="long" coulumn="sid">
            <generator class="native"/>
        </id>
        <property name="name" type="String" column="sname"/>
        <union-subclass name="GradStudent" table="GRAD_STU">
            <property name="number" type="long" column="NUMBER"/>
            <property name="bdate" type="String" column="BDATE"/>
            ...
        </union-subclass>
        <union-subclass name="DocStudent" table="DOC_STU">
            ...
        </union-subclass>
    </class>
</hibernate-mapping>

using the <subclass/> and <join /> Interitance Strategy
<class name=" " acstract="true">
    <id name=" " type=" " column=" ">
        ...
    </id>
    <discriminator column="type" type="String"/>
    <subclass name=" " discriminator-value="GC">
        <join table=" ">
            <key coulumn=" "/>
            <property name=" " type=" " column=" "/>
        </join>
    </subclass>
</class>









                







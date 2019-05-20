//price is larger than 23.0 or name like Tab% or description ilike mouse
Criteria crit=session.CreateCriteria(Product.class);
Criterion pricels=Restrictions.lt("price",23.0);
Criterion name=Restrictions.like("name","Tab%");
Criterion des=Restrictions.ilke("description","mouse",MatchMode.ANYWHERE);
Disjuction dis=Restrictions.disjuction();
dis.add(pricels);
dis.add(name);
dis.add(des);
crit.add(dis);
List<Product> res=crit.list();


//two or LogicExpression
Criteria crit=session.createCriteria(Product.class);
Criterion pricels=Restrictions.lt("price",23.0);
Criterion name=Restrictions.like("name","Tab%");
LogicExpression ox=Restrictions.or(pricels,name);
crit.add(ox);
List<Product> res=crit.list();

//Paging setFirstResult() setMaxResult()
Criteria crit=session.createCriteria(Product.class);
crit.setFirstResult(1); 
crit.setMaxResult(20);
List<Product> res=crit.list();


//projection
crit.seteProjection(Projections.rowCount());
//apply more than one projection
ProjectionList pl=Projections.projectionList();
pl.add(Projections.max("price"));
pl.add(Projections.min("price"));
pl.add(Projections.avg("price"));
pl.add(Projections.countDistinct("description"));
crit.setProjection(pl);
List<Object[]> result=crit.list();

//multiple affregate projections ==>projection for property
...
ProjectionList pl=Projecyions.projectionList();
pl.add(Projecyions.property("price"));
pl.add(Projecyions.property("name"));
crit.setProjection(pl);
List<Object[]> res=crit.list();

//one to one
/*
1.give same primary key
2.using a foreign key constraint from one table onto a unique identifier column of the other
*/


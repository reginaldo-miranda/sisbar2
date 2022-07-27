package model;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-27T08:51:44", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(MoPdv.class)
public class MoPdv_ { 

    public static volatile SingularAttribute<MoPdv, Integer> parcelas;
    public static volatile SingularAttribute<MoPdv, Calendar> data;
    public static volatile SingularAttribute<MoPdv, Double> valorTotal;
    public static volatile SingularAttribute<MoPdv, Integer> id_clientes;
    public static volatile SingularAttribute<MoPdv, Integer> id;
    public static volatile SingularAttribute<MoPdv, String> clientes;

}
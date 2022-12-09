package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.Date.*;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {
//Tests de la fonction isLeapYear
//Test du block où L'année est divisible par 400
@Test
public void Test_Pass_isLeapYear400(){
    assertTrue(isLeapYear(1200),"On passe le test");
}

//Test du block où l'année n'est pas divisible par 400 mais par 100
@Test
public void Test_Pass_isLeapYear100(){
    assertFalse(isLeapYear(1300),"On a bien l'année qui est divisible par 100");
}

}
//Test du block non divisible par 400 et 100 mais divisible par 4
@Test
public void Test_Pass_isLeapYear4(){
    assertTrue(isLeapYear(2020),"On a bien une année divisible par 4");
}

//Test du block où l'année n'est pas bissextile (ni divisible par 400, 100 ou 4)
@Test
public void Test_Error_isLeapYear(){
    assertFalse(isLeapYear(2022),"On a bien que l'année n'est pas bissextile");
}

//----------------------------------------------------------------------------------------------------------

//Tests de la méthode isValidDate
//Test du block ou l'année est bissextile, le mois est février et la date est fautif (Supérieur à 28)
@Test
public void Test_Error_isValidDate_BisFebSup(){
    assertFalse(isValidDate(30,2,2020),"On a bien une erreur");
}
//Test du block ou l'année est bissextile, le mois est février et la date est fautif (Inférieur à 1)
@Test
public void Test_Error_isValidDate_BisFebInf(){
    assertFalse(isValidDate(0,2,2020),"On a bien une erreur");
}

//Test du block ou le mois est fautif (supérieur à 12)
@Test
public void Test_Error_isValidDate_MonthSup(){
    assertFalse(isValidDate(3,13,2000),"On a bien une erreur");
}

//Test du block ou le mois est fautif (inférieur à 1)
@Test
public void Test_Error_isValidDate_MonthInf(){
    assertFalse(isValidDate(3,0,2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois impair (day sup, avant Aout)
@Test
public void Test_Error_isValidDate_DayImpSupJ(){
    assertFalse(isValidDate(32, 1, 2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois impair (day inf, avant Aout)
@Test
public void Test_Error_isValidDate_DayImpOInfJ(){
    assertFalse(isValidDate(0, 1, 2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois impair (day sup, après Aout)
@Test
public void Test_Error_isValidDate_DayImpSupA(){
    assertFalse(isValidDate(32, 9, 2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois pair (day inf, avant Aout)
@Test
public void Test_Error_isValidDate_DayPairOInfJ(){
    assertFalse(isValidDate(0, 4, 2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois impair (day sup, après Aout)
@Test
public void Test_Error_isValidDate_DayPairSupA(){
    assertFalse(isValidDate(32, 9, 2000),"On a bien une erreur");
}
//Test du block ou la date est fautif en mois impair (day inf, après Aout)
@Test
public void Test_Error_isValidDate_DayImpOInfA(){
    assertFalse(isValidDate(0, 9, 2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois pair (day sup)
@Test
public void Test_Error_isvalidDate_DayPairSup(){
    assertFalse(isValidDate(31,6,2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois pair (day inf)
@Test
public void Test_Error_isvalidDate_DayPairInf(){
    assertFalse(isValidDate(0,6,2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois pair (day sup)
@Test
public void Test_Error_isvalidDate_DayPairSupA(){
    assertFalse(isValidDate(32,10,2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en mois pair (day inf, après août)
@Test
public void Test_Error_isvalidDate_DayPairInfA(){
    assertFalse(isValidDate(0,10,2000),"On a bien une erreur");
}

//Test du block ou la date est fautif en février(day supérieur à 29)
@Test
public void Test_Error_isValidDate_DayFebSup(){
    assertFalse(isValidDate(31,2,2001),"On a bien une erreur");
}

//Test du block ou la date est fautif en février(day supérieur à 29)
@Test
public void Test_Error_isValidDate_DayFebInf(){
    assertFalse(isValidDate(0,2,2001),"On a bien une erreur");
}

//Test du block ou la date est correct et en février 
@Test
public void Test_Pass_isValidDate_Feb(){
    assertTrue(isValidDate(3,2,2001),"On passe bien le test");
}

//Test du block ou on est en année bissextile, en février et la date est correct
@Test
public void Test_Pass_isValidDate_BF(){
    assertTrue(isValidDate(29,2,2000),"On passe bien le test");
}

//Test du block où non Bissextile, Février date fausse
@Test
public void Test_Error_isValidDate_Feb(){
    assertFalse(isValidDate(30,2,1999),"On a bien une erreur");
}

//Test du block où mois impair et date correct (avant J)
@Test
public void Test_Pass_isValidDate_ImpJ(){
    assertTrue(isValidDate(3,3,2003),"On passe bien le test");
}

//Test du block où mois pair et date correct (avant J)
@Test
public void Test_Pass_isValidDate_PairJ(){
    assertTrue(isValidDate(3,4,2003),"On passe bien le test");
}

//Test du block pour la négation du if(month<8)
@Test
public void Test_Pass_isValidDate_A(){
    assertTrue(isValidDate(31,8,2022));
}

//----------------------------------------------------------------------------------------------------------

//Tests de la méthode compareto
//Test la date est postérieur day
@Test
public void Test_Pos_compareTo_Day(){
    Date date1=new Date(4,2,2000);
    Date date2=new Date(2,2,2000);
    int val=date1.compareTo(date2);
    assertTrue(val>0);
}

//Test la date est antérieur day
@Test
public void Test_Ant_compareTo_Day(){
    Date date1=new Date(2,2,2000);
    Date date2=new Date(3,2,2000);
    int val=date1.compareTo(date2);
    assertTrue(val<0);
}

//Test du block month antérieur
@Test
public void Test_Ant_compareTo_Month(){
    Date date1=new Date(2,2,2000);
    Date date2=new Date(2,3,2000);
    int val=date1.compareTo(date2);
    assertTrue(val<0);
}

//Test du block month postérieur
@Test
public void Test_Pos_compareTo_Month(){
    Date date1=new Date(2,3,2000);
    Date date2=new Date(2,2,2000);
    int val=date1.compareTo(date2);
    assertTrue(val>0);
}

//Test du block year antérieur
@Test
public void Test_Ant_compareTo_Year(){
    Date date1=new Date(2,2,2000);
    Date date2=new Date(2,2,2001);
    int val=date1.compareTo(date2);
    assertTrue(val<0);
}

//Test du block year postérieur 
@Test
public void Test_Pos_compareTo_Year(){
    Date date1=new Date(2,2,2001);
    Date date2=new Date(2,2,2000);
    int val=date1.compareTo(date2);
    assertTrue(val>0);
}
//Test les dates sont les mêmes
@Test
public void Test_Same_compareTo_Day(){
    Date date1=new Date(2,2,2000);
    Date date2=new Date(2,2,2000);
    int val=date1.compareTo(date2);
    assertTrue(val==0);
}
//----------------------------------------------------------------------------------------------------------

//Tests du nextDate
//Test avancement de la date
@Test
public void Test_Day_nextDate(){
    Date date1=(new Date(1,3,2000)).nextDate();
    Date date2=new Date(2,3,2000);
    assertTrue(date1.compareTo(date2)==0);
}

//Test du block où on se situe au dernier jour du mois
@Test
public void Test_Month_nextDate(){
    Date date1=(new Date(30,11,2000)).nextDate();
    System.out.println(isValidDate(31,11,2000));
    Date date2=new Date(1,12,2000);
    assertTrue(date1.compareTo(date2)==0);
}

//test du block ou on se situe au dernier jour de l'année
@Test
public void Test_Year_nextDate(){
    Date date1=(new Date(31,12,2000)).nextDate();
    Date date2=new Date(1,1,2001);
    assertTrue(date1.compareTo(date2)==0);
}

//----------------------------------------------------------------------------------------------------------

//Ensemble de tests de la méthode previousDate()
//Test du block où la date n'est pas le premier jour du mois.
@Test
public void Test_PreviousDate(){
    Date date1=(new Date(8,12,2022)).previousDate();
    Date date2=new Date(7,12,2022);
    assertTrue(date1.compareTo(date2)==0);
}

//Test du block où la date est le premier jour d'un mois pair.
@Test
public void Test_PreviousDate_Pair(){
    Date date1=(new Date(1,12,2022)).previousDate();
    Date date2=new Date(30,11,2022);
    assertTrue(date1.compareTo(date2)==0);
}

//Test du block où la date est le premier jour d'un mois impair.
@Test
public void Test_PreviousDate_Imp(){
    Date date1=(new Date(1,11,2022)).previousDate();
    Date date2=new Date(31,10,2022);
    assertTrue(date1.compareTo(date2)==0);
}

//Test du block où la date est le premier jour du mois de mars.
@Test
public void Test_PreviousDate_Feb(){
    Date date1=(new Date(1,3,2022)).previousDate();
    Date date2=new Date(28,2,2022);
    assertTrue(date1.compareTo(date2)==0);
}

//Test du block où la date est le premier jour du mois de mars en année bissextile.
@Test
public void Test_PreviousDate_FebBis(){
    Date date1=(new Date(1,3,2020)).previousDate();
    Date date2=new Date(29,2,2020);
    assertTrue(date1.compareTo(date2)==0);
}

//Test du block où la date est le premier jour de l'année
@Test 
public void Test_PreviousDate_FirstDay(){
    Date date1=(new Date(1,1,2020)).previousDate();
    Date date2=new Date(31,12,2019);
    assertTrue(date1.compareTo(date2)==0);
}

//Test du block où la date est en août
@Test 
public void Test_PreviousDate_A(){
    Date date1=(new Date(1,8,2019)).previousDate();
    Date date2=new Date(31,7,2019);
    assertTrue(date1.compareTo(date2)==0);
}

//----------------------------------------------------------------------------------------------------------

//test sur le constructeur
@Test
public void Test_Exception_Constructor(){
    assertThrows(IllegalArgumentException.class,()->new Date(0,0,0));
}
}
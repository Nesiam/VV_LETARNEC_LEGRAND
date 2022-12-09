package fr.istic.vv;
import org.junit.jupiter.api.Test;
import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {


	//Test du blocks avec la parenthèse fautif
	@Test
	public void Test_ErrorParent(){
		assertFalse(isBalanced("{[](}"),"On a bien une erreur");
	}

}
	//Test du block avec le crochet fautif
	@Test
	public void Test_ErrorCrochet(){
		assertFalse(isBalanced("{}([])["),"On a bien une erreur");
	}

	//Test du block avec l'accolade fautif
	@Test
	public void Test_ErrorAccol(){
		assertFalse(isBalanced("([]}[])"),"On a bien une erreur");
	}

	//Test du block ou tous sont fautif
	@Test
	public void Test_ErrorAll(){
		assertFalse(isBalanced("([{"),"On a bien une erreur");
	}

	//Test du block ou la parenthèse et l'accolade sont fautif
	@Test
	public void Test_ErrorParentAccol(){
		assertFalse(isBalanced("[)}]"), "On a bien une erreur");
	}

	//Test du block ou la parenthèse et le crochet sont fautif
	@Test
	public void Test_ErrorParentCroc(){
		assertFalse(isBalanced("{(]}"),"On a bien une erreur");
	}

	//Test du block ou l'accolade et le crochet sont fautif
	@Test
	public void Test_ErrorCrocAccol(){
		assertFalse(isBalanced("({])"),"On a bien une erreur");
	}

	//Test du block réussi
	@Test
	public void Test_PassisBalanced(){
		assertTrue(isBalanced("(([][]){})"),"On passe bien le test");
	}

  //Test du block où on ajoute des charactère différents de (, [, {.
	@Test
	public void Test_PassString(){
		assertTrue(isBalanced("(Bonjour je passe)"),"On passe bien le test");
	}


	@Test
	public void Test_ErrorString(){
		assertFalse(isBalanced("Ce message ne passe pas ("),"On a bien une erreur");
	}


}
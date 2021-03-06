package de.fhg.iais.roberta.syntax.action.nao;

import org.junit.Assert;
import org.junit.Test;

import de.fhg.iais.roberta.util.test.nao.Helper;

public class PointAtMissingNumbersTest {
    Helper h = new Helper();

    @Test
    public void make_ByDefault_ReturnInstanceOfPointLookAtRobotClass() throws Exception {
        String expectedResult = "BlockAST [project=[[Location [x=138, y=88], " + "MainTask [], " + "PointLookAt [ROBOT, POINT, EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT]]]]]";
        
        String result = this.h.generateTransformerString("/action/pointAt_robot_missingNumbers.xml");

        Assert.assertEquals(expectedResult, result);
    }
    
    @Test
    public void make_ByDefault_ReturnInstanceOfPointLookAtWorldClass() throws Exception {
        String expectedResult = "BlockAST [project=[[Location [x=138, y=88], " + "MainTask [], " + "PointLookAt [WORLD, POINT, EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT]]]]]";
        
        String result = this.h.generateTransformerString("/action/pointAt_world_missingNumbers.xml");

        Assert.assertEquals(expectedResult, result);
    }
    
    @Test
    public void make_ByDefault_ReturnInstanceOfPointLookAtTorsoClass() throws Exception {
        String expectedResult = "BlockAST [project=[[Location [x=138, y=88], " + "MainTask [], " + "PointLookAt [TORSO, POINT, EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT], EmptyExpr [defVal=NUMBER_INT]]]]]";
        
        String result = this.h.generateTransformerString("/action/pointAt_torso_missingNumbers.xml");

        Assert.assertEquals(expectedResult, result);
    }

    /*
    @Test
    public void astToBlock_XMLtoJAXBtoASTtoXML_ReturnsSameXML() throws Exception {

        this.h.assertTransformationIsOk("/action/pointAt_robot.xml");
    }*/
}
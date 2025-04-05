package br.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {


    Triangle triangleScalene = new Triangle(5.0,4.0,3.0);
    Triangle triangleIsosceles = new Triangle(10.0,10.0,12.0);
    Triangle triangleEquilateral = new Triangle(6.0,6.0,6.0);


    @Test
    void isTriangleTest_whenIsNotTriangle_ShouldThrowException(){
        Triangle triangleEmpty = new Triangle();
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(2.0,2.0,5.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(5.0,1.0,2.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(1.0,2.0,5.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(2.0,5.0,1.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(10.0,3.0,4.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(1.0,2.0,3.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(3.0,2.0,1.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(2.0,1.0,3.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        Assertions.assertThrows(RuntimeException.class, () -> triangleEmpty.validateTriangleSizes(1.0,3.0,2.0), "Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
    }

    @Test
    void isTriangleTest_whenIsTriangle_ShouldSizes(){
        Triangle triangle = new Triangle(5.0,4.0,3.0);
        Triangle triangle2 = new Triangle(3.0,4.0,5.0);
        Triangle triangle3 = new Triangle(4.0,3.0,5.0);
        Triangle triangle4 = new Triangle(3.0,5.0,4.0);

        // Asserts para triangle (5.0, 4.0, 3.0)
        Assertions.assertEquals(5.0, triangle.getSizeOne());
        Assertions.assertEquals(4.0, triangle.getSizeTwo());
        Assertions.assertEquals(3.0, triangle.getSizeThree());

        // Asserts para triangle2 (3.0, 4.0, 5.0)
        Assertions.assertEquals(3.0, triangle2.getSizeOne());
        Assertions.assertEquals(4.0, triangle2.getSizeTwo());
        Assertions.assertEquals(5.0, triangle2.getSizeThree());

        // Asserts para triangle3 (4.0, 3.0, 5.0)
        Assertions.assertEquals(4.0, triangle3.getSizeOne());
        Assertions.assertEquals(3.0, triangle3.getSizeTwo());
        Assertions.assertEquals(5.0, triangle3.getSizeThree());

        // Asserts para triangle4 (3.0, 5.0, 4.0)
        Assertions.assertEquals(3.0, triangle4.getSizeOne());
        Assertions.assertEquals(5.0, triangle4.getSizeTwo());
        Assertions.assertEquals(4.0, triangle4.getSizeThree());

    }

    //SCALENE
    @Test
    void scaleneTriangleTest_whenIsScaleneTriangle_ShouldReturnTrue(){
        Assertions.assertTrue(triangleScalene.isScalene());
        Assertions.assertTrue(!triangleIsosceles.isScalene());
        Assertions.assertTrue(!triangleEquilateral.isScalene());
    }

    @Test
    void scaleneTriangleTest_whenIsNotScaleneTriangle_ShouldReturnFalse(){
        Assertions.assertFalse(triangleIsosceles.isScalene());
        Assertions.assertFalse(triangleEquilateral.isScalene());
    }

    // ISOSCELES
    @Test
    void isoscelesTriangleTest_whenIsIsoscelesTriangle_ShouldReturnTrue(){
        Triangle triangleIsosceles1 = new Triangle(7.0,7.0,10.0);
        Triangle triangleIsosceles2 = new Triangle(7.0,10.0,7.0);
        Triangle triangleIsosceles3 = new Triangle(10.0,7.0,7.0);
        Triangle triangleIsosceles4 = new Triangle(4.0,4.0,4.5);
        Triangle triangleIsosceles5 = new Triangle(5.0,5.0,3.0);
        Assertions.assertTrue(triangleIsosceles1.isIsosceles());
        Assertions.assertTrue(triangleIsosceles2.isIsosceles());
        Assertions.assertTrue(triangleIsosceles3.isIsosceles());
        Assertions.assertTrue(triangleIsosceles4.isIsosceles());
        Assertions.assertTrue(triangleIsosceles5.isIsosceles());
        Assertions.assertTrue(triangleIsosceles.isIsosceles());
        Assertions.assertTrue(!triangleScalene.isIsosceles());
    }

    @Test
    void isoscelesTriangleTest_whenIsNotIsoscelesTriangle_ShouldReturnTrue(){
        Assertions.assertFalse(triangleEquilateral.isScalene());
    }

    // EQUILATERAL
    @Test
    void isEquilateralTriangleTest_whenIsEquilateralTriangle_ShouldReturnTrue(){
        Assertions.assertTrue(triangleEquilateral.isEquilateral());
    }

    @Test
    void isEquilateralTriangleTest_whenIsNotEquilateralTriangle_ShouldReturnFalse(){
        Triangle betterStranger = new Triangle(4.0,3.0,5.0);
        Assertions.assertFalse(betterStranger.isEquilateral());
        Assertions.assertFalse(triangleEquilateral.isScalene());
    }
    @Test
    void valueInvalidToTriangle_ShouldThrowException(){
        Triangle triangleInvalid = new Triangle();
        Assertions.assertThrows(RuntimeException.class, () -> triangleInvalid.InvalidValue(0.0,-1.0,-1.0),"Number of sides must be greater than zero");
        Assertions.assertThrows(RuntimeException.class, () -> triangleInvalid.InvalidValue(0.0,0.0,0.0),"Number of sides must be greater than zero");
        Assertions.assertThrows(RuntimeException.class, () -> triangleInvalid.InvalidValue(2.0,1.0,-1.0),"Number of sides must be greater than zero");
        Assertions.assertThrows(RuntimeException.class, () -> triangleInvalid.InvalidValue(-1.0,2.0,1.0),"Number of sides must be greater than zero");
        Assertions.assertThrows(RuntimeException.class, () -> triangleInvalid.InvalidValue(1.0,-1.0,2.0),"Number of sides must be greater than zero");
    }

}
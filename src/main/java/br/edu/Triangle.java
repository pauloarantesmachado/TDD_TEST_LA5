package br.edu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Triangle {

    private Double sizeOne;
    private Double sizeTwo;
    private Double sizeThree;

    public Triangle(Double sizeOne, Double sizeTwo, Double sizeThree)
    {
            this.InvalidValue(sizeOne,sizeTwo,sizeThree);
            this.validateTriangleSizes(sizeOne, sizeTwo, sizeThree);
            this.sizeOne = sizeOne;
            this.sizeTwo = sizeTwo;
            this.sizeThree = sizeThree;
    }

    protected void validateTriangleSizes(Double...pSizes)
    {
        if(!isTriangle(pSizes)){
            throw new RuntimeException("Triangle size must to follow this rule  a+b > c && a+c > b && b+c > a");
        }
    }

    private Boolean isTriangle(Double...sizes)
    {
        return sizes[0] < sizes[1] + sizes[2] &&
                sizes[1] < sizes[0] + sizes[2] &&
                sizes[2] < sizes[0] + sizes[1];
    }

    protected Boolean isScalene()
    {
        return !isIsosceles();
    }

    public Boolean isIsosceles()
    {
        return this.sizeOne.equals(sizeTwo) ||
                this.sizeOne.equals(sizeThree) ||
                this.sizeTwo.equals(sizeThree);
    }

    protected Boolean isEquilateral()
    {
        return  this.sizeOne.equals(sizeTwo) &&
                this.sizeOne.equals(sizeThree);
    }

    protected void InvalidValue(Double sizeOne, Double sizeTwo, Double sizeThree)
    {
        if (negativeNumber(sizeOne,sizeTwo,sizeThree))
        {
            throw new RuntimeException("Number of sides must be greater than zero");
        }
    }

    private boolean negativeNumber(Double sizeOne, Double sizeTwo, Double sizeThree)
    {
        return sizeOne <= 0.0 || sizeTwo <= 0.0 || sizeThree <= 0.0;
    }
}

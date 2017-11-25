package Part2;

public class CominicationClass {
    private KezbansIngredients kezbansIngredient = null;
    private boolean metinFlag = false, aliFlag = false, feyyazFlag = false;
    private boolean processFlag = false;
    public void setIngredient(KezbansIngredients ingredient)
    {
        synchronized (this)
        {
            if(ingredient.equals(KezbansIngredients.InputAndOutput))
            {
                aliFlag = true;
            }
            else if(ingredient.equals(KezbansIngredients.InputAndTransformer))
            {
                feyyazFlag = true;
            }
            else if(ingredient.equals(KezbansIngredients.TransformerAndOutput))
            {
                metinFlag = true;
            }
            this.notifyAll();
        }

    }

    public synchronized boolean getProcessFlag()
    {
        return processFlag;
    }
    public synchronized void setProcessFlag(boolean status)
    {
        processFlag = status;
    }

    public synchronized void  resetFlags()
    {
        metinFlag = false;
        aliFlag = false;
        feyyazFlag = false;
    }

    public synchronized boolean isMetinFlag() {
        try {
            if(!metinFlag)
                this.wait();
        }catch (InterruptedException e)
        {

        }

        return metinFlag;
    }

    public synchronized boolean isAliFlag() {
        try {
            if(!aliFlag)
                this.wait();
        }catch (InterruptedException e)
        {

        }
        return aliFlag;
    }

    public synchronized boolean isFeyyazFlag() {
        try {
            if(!feyyazFlag)
                this.wait();
        }catch (InterruptedException e)
        {

        }
        return feyyazFlag;
    }
}

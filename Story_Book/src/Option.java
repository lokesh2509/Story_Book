public class Option {
    String opText;
    int nextId;
    boolean changeGooState = false;
    boolean changeSwordState = false;
    boolean changeShieldState = false;
    boolean reset = false;

    Option(String opText, int nextId){
        this.opText = opText;
        this.nextId = nextId;
    }

    Option(String opText, int nextId, boolean changeGooState){
        this.opText = opText;
        this.nextId = nextId;
        System.out.println(HomeFrame.blueGoo);
        this.changeGooState = changeGooState;
    }

    Option(String opText, int nextId, boolean changeGooState, boolean changeSwordState){
        this.opText = opText;
        this.nextId = nextId;
        this.changeGooState = changeGooState;
        this.changeSwordState = changeSwordState;
    }

    Option(String opText, int nextId, boolean changeGooState, boolean changeSwordState, boolean changeShieldState){
        this.opText = opText;
        this.nextId = nextId;
        this.changeGooState = changeGooState;
        this.changeSwordState = changeSwordState;
        this.changeShieldState = changeShieldState;
    }

    Option(String opText, int nextId, boolean changeGooState, boolean changeSwordState, boolean changeShieldState, boolean reset){
        this.opText = opText;
        this.nextId = nextId;
        this.reset = reset;
    }

    public void selected(){
        if (changeGooState) {
            boolean currentBlueGoo= HomeFrame.blueGoo;
            HomeFrame.blueGoo = !currentBlueGoo;
            System.out.println("goo state: "+ HomeFrame.blueGoo);
        }
        if (changeSwordState) {
            boolean currentSword= StoryFlow.sword;
            StoryFlow.sword = !currentSword;
        }
        if (changeShieldState) {
            boolean currentShield = StoryFlow.shield;
            StoryFlow.shield = !currentShield;
        }
        if(reset){
            changeShieldState= false; changeGooState = false; changeSwordState= false; reset = false;
            StoryFlow.shield = false; StoryFlow.sword = false; HomeFrame.blueGoo = false;
//            System.exit(0);
        }
        HomeFrame.currPage = nextId;
    }



}

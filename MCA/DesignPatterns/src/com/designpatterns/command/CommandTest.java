package com.designpatterns.command;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.command
 * Version: V1.0
 */

public class CommandTest {
    public static void main(String[] args) {
        Command cmd1 = new Command1();
        Command cmd2 = new Command2();
        StringBuffer sb = new StringBuffer("hahaaha");
        System.out.println(sb.toString());
        cmd1.sendCmd(sb);
        System.out.println(sb.toString());
        cmd2.sendCmd(sb);
        System.out.println(sb.toString());
        cmd2.sendBack(sb);
        System.out.println(sb.toString());
        cmd1.sendBack(sb);
        System.out.println(sb.toString());
    }
}


abstract class CmdExector {
    abstract boolean doExec(StringBuffer context);
    abstract boolean doBack(StringBuffer context);
}

class CmdExector1 extends CmdExector {
    @Override
    boolean doExec(StringBuffer context) {
        context.append("+111");
        return true;
    }

    @Override
    boolean doBack(StringBuffer context) {
        context.replace(context.length() - 4, context.length(), "");
        return true;
    }
}

class CmdExector2 extends CmdExector {
    @Override
    boolean doExec(StringBuffer context) {
        context.append("+222");
        return true;
    }

    @Override
    boolean doBack(StringBuffer context) {
        context.replace(context.length() - 4, context.length(), "");
        return true;
    }
}

abstract class Command {
    abstract boolean sendCmd(StringBuffer context);
    abstract boolean sendBack(StringBuffer context);
}

class Command1 extends Command {
    CmdExector1 exector = new CmdExector1();
    @Override
    boolean sendCmd(StringBuffer context) {
        return exector.doExec(context);
    }

    @Override
    boolean sendBack(StringBuffer context) {
        return exector.doBack(context);
    }
}

class Command2 extends Command {
    CmdExector2 exector = new CmdExector2();
    @Override
    boolean sendCmd(StringBuffer context) {
        return exector.doExec(context);
    }

    @Override
    boolean sendBack(StringBuffer context) {
        return exector.doBack(context);
    }
}




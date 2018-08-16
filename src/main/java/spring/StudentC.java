package main.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liyujiang on 2018/8/15.
 */
public class StudentC {

    @Autowired
    @Qualifier("blackPen")
    private Pen pen;

    @Autowired   //属性自动填充
    private Clothes wearClothes;

    private Clothes backupClothes;

    void write() {
        System.out.println("i'm wear:" + wearClothes.toString() + " use: " + pen.toString());
    }

    @Autowired     //setter自动填充
    public void setBackupClothes(Clothes backupClothes) {
        this.backupClothes = backupClothes;
    }

    public Clothes getBackupClothes() {
        return backupClothes;
    }
}

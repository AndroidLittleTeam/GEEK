package com.alenbeyond.runoob.greendao.bean;

import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.greendao.gen.RunoobChapterDao;
import com.alenbeyond.runoob.greendao.gen.RunoobItemDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/8/4.
 */
@Entity
public class RunoobItem {
    @Id
    private Long id;
    private Long categroyId;
    private String title;// 标题
    private String image;// 图片
    private String link;// 链接
    private String des;// 描述
    @ToMany(referencedJoinProperty = "itemId")
    private List<RunoobChapter> runoobChapter;//章节
    /** Used for active entity operations. */
    @Generated(hash = 498137178)
    private transient RunoobItemDao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    @Generated(hash = 634575831)
    public RunoobItem(Long id, Long categroyId, String title, String image, String link, String des) {
        this.id = id;
        this.categroyId = categroyId;
        this.title = title;
        this.image = image;
        this.link = link;
        this.des = des;
    }

    public RunoobItem(String title, String image, String link, String des) {
        this.title = title;
        this.image = image;
        this.link = link;
        this.des = des;
    }

    @Generated(hash = 41426515)
    public RunoobItem() {
    }


    @Override
    public String toString() {
        return "RunoobItem [title=" + title + ", image=" + image + ", link=" + link + ", des=" + des + "]";
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1609797167)
    public synchronized void resetRunoobChapter() {
        runoobChapter = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2130953363)
    public List<RunoobChapter> getRunoobChapter() {
        if (runoobChapter == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RunoobChapterDao targetDao = daoSession.getRunoobChapterDao();
            List<RunoobChapter> runoobChapterNew = targetDao._queryRunoobItem_RunoobChapter(id);
            synchronized (this) {
                if(runoobChapter == null) {
                    runoobChapter = runoobChapterNew;
                }
            }
        }
        return runoobChapter;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategroyId() {
        return this.categroyId;
    }

    public void setCategroyId(Long categroyId) {
        this.categroyId = categroyId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1193112059)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRunoobItemDao() : null;
    }

}

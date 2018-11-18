package com.shymaaothman.photogallarytask.data.remote.models;

/**
 * Created by Shymaa on 11/16/2018.
 */

public class Links {


        private String download;

        private String html;

        private String self;

        public String getDownload ()
        {
            return download;
        }

        public void setDownload (String download)
        {
            this.download = download;
        }

        public String getHtml ()
        {
            return html;
        }

        public void setHtml (String html)
        {
            this.html = html;
        }

        public String getSelf ()
        {
            return self;
        }

        public void setSelf (String self)
        {
            this.self = self;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [download = "+download+", html = "+html+", self = "+self+"]";
        }

}

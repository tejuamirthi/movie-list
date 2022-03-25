package com.assignment.movielist.Models;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@ResponseBody
public class ResponseParse {

    private Parse parse;

    public Parse getParse() {
        return parse;
    }

    public void setParse(Parse parse) {
        this.parse = parse;
    }

    @ResponseBody
    public static class Parse {
        public String title;
        public Long pageid;
        public Map<String,String> text;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getPageid() {
            return pageid;
        }

        public void setPageid(Long pageid) {
            this.pageid = pageid;
        }

        public Map<String,String> getText() {
            return text;
        }

        public void setText(Map<String,String> text) {
            this.text = text;
        }
    }
}

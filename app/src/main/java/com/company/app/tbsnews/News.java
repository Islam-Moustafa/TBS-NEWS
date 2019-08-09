/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.company.app.tbsnews;

// Class News contain information related to single NEW.
public class News {

    // Title of the News
    private String title;

    // Publish date of the News
    private String webPublicationDate;

    // Website URL of the News, to take more details
    private String url;

    /**
     * Constructs a new News object.
     *
     * @param title is the title of the News
     * @param webPublicationDate is the date of published News
     * @param url is the website URL to read more details about the News
     */
    public News(String title , String webPublicationDate, String url){
        this.title = title;
        this.webPublicationDate = webPublicationDate;
        this.url = url;
    }

    // Return title of the News
    public String getTitle(){return title;}

    // Return webPublicationDate of the News
    public String getWebPublicationDate(){return webPublicationDate;}

    //Return URL of the News
    public String getUrl(){return url;}
}

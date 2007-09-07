/*
 * ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 * 
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 ("License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.zimbra.com/license
 * 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and limitations
 * under the License.
 * 
 * The Original Code is: Zimbra Collaboration Suite Server.
 * 
 * The Initial Developer of the Original Code is Zimbra, Inc.
 * Portions created by Zimbra are Copyright (C) 2006 Zimbra, Inc.
 * All Rights Reserved.
 * 
 * Contributor(s): 
 * 
 * ***** END LICENSE BLOCK *****
 */
package com.zimbra.cs.taglib.bean;

import com.zimbra.cs.zclient.ZTag;

public class ZTagBean {

    private ZTag mTag;
    
    public ZTagBean(ZTag tag){
        mTag = tag;
    }

    public String getId() { return mTag.getId(); }

    public String getName() { return mTag.getName(); }

    public int getUnreadCount() { return mTag.getUnreadCount(); }
    
    public boolean getHasUnread() { return getUnreadCount() > 0; }

    public String getColor() { return mTag.getColor().name(); }
    
    public String getImage() {
        switch(mTag.getColor()) {
        case blue:
            return "startup/ImgTagBlue.gif";
        case cyan:
            return "startup/ImgTagCyan.gif";
        case green:
            return "startup/ImgTagGreen.gif";
        case purple: 
            return "startup/ImgTagPurple.gif";
        case red:
            return "startup/ImgTagRed.gif";
        case yellow: 
            return "startup/ImgTagYellow.gif";
        case orange:
        default:
            return "startup/ImgTagOrange.gif";
        }
    }
    
    public String getMiniImage() {
        switch(mTag.getColor()) {
        case blue:
            return "startup/ImgTagBlue.gif";
        case cyan:
            return "startup/ImgTagCyan.gif";
        case green:
            return "startup/ImgTagGreen.gif";
        case purple: 
            return "startup/ImgTagPurple.gif";
        case red:
            return "startup/ImgTagRed.gif";
        case yellow: 
            return "startup/ImgTagYellow.gif";
        case orange:
        default:
            return "startup/ImgTagOrange.gif";
        }
    }

}

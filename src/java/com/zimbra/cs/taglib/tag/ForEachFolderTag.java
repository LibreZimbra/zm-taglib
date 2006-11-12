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
package com.zimbra.cs.taglib.tag;

import com.zimbra.cs.service.ServiceException;
import com.zimbra.cs.taglib.bean.ZFolderBean;
import com.zimbra.cs.zclient.ZFolder;
import com.zimbra.cs.zclient.ZMailbox;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import java.io.IOException;
import java.util.List;

public class ForEachFolderTag extends ZimbraSimpleTag {
    
    private String mVar;
    private String mParentId;
    private boolean mSkipRoot = true;
    private boolean mSkipSystem = false;

    public void setParentid(String parentId) { this.mParentId = parentId != null && parentId.length() ==0 ? null : parentId; }
    public void setVar(String var) { this.mVar = var; }
    public void setSkiproot(boolean skiproot) { this.mSkipRoot = skiproot; }
    public void setSkipsystem(boolean skipsystem) { this.mSkipSystem = skipsystem; }
    
    public void doTag() throws JspException, IOException {
        JspFragment body = getJspBody();
        if (body == null) return;
        
        try {
            ZMailbox mbox = getMailbox();
            JspContext jctxt = getJspContext();
            handleFolder(mParentId == null ? mbox.getUserRoot() : mbox.getFolderById(mParentId), body, jctxt, mSkipRoot, mSkipSystem);            
        } catch (ServiceException e) {
            getJspContext().getOut().write(e.toString());
        }
    }    
    
    private void handleFolder(ZFolder folder, JspFragment body, JspContext jctxt, boolean skip, boolean skipsystem)
    throws ServiceException, JspException, IOException {
        if (folder == null)
            return;

        if (skipsystem && folder.isSystemFolder() && !folder.getId().equals(ZFolder.ID_USER_ROOT))
            return;
        
        if (!skip) {
            jctxt.setAttribute(mVar, new ZFolderBean(folder));
            body.invoke(null);
        }
        List<ZFolder> subfolders = folder.getSubFolders();
        for (ZFolder subfolder : subfolders) {
            if (subfolder != null)
                handleFolder(subfolder, body, jctxt, false, skipsystem);
        }
    }
}
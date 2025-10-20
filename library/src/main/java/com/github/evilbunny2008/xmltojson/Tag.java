package com.github.evilbunny2008.xmltojson;
/*
    Copyright 2016 Arnaud Guyon

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;

/**
 * Class used to store XML hierarchy
 *
 */

@SuppressWarnings("unused")
public class Tag
{
    private final String mPath;
    private final String mName;
    private final ArrayList<Tag> mChildren = new ArrayList<>();
    private String mContent;

    Tag(String path, String name)
    {
        mPath = path;
        mName = name;
    }

    void addChild(Tag tag)
    {
        mChildren.add(tag);
    }

    void setContent(String content)
    {
        // checks that there is a relevant content (not only spaces or \n)
        boolean hasContent = false;
        if(content != null)
		{
            for(int i=0; i<content.length(); ++i)
			{
                char c = content.charAt(i);
                if((c != ' ') && (c != '\n'))
				{
                    hasContent = true;
                    break;
                }
            }
        }

        if(hasContent)
            mContent = content;
    }

    String getName() {
        return mName;
    }

    String getContent() {
        return mContent;
    }

    ArrayList<Tag> getChildren()
    {
        return mChildren;
    }

    boolean hasChildren()
    {
        return !mChildren.isEmpty();
    }

    int getChildrenCount()
    {
        return mChildren.size();
    }

    Tag getChild(int index)
    {
        if((index >= 0) && (index < mChildren.size()))
            return mChildren.get(index);

        return null;
    }

    HashMap<String, ArrayList<Tag>> getGroupedElements()
    {
        HashMap<String, ArrayList<Tag>> groups = new HashMap<>();
        for(Tag child : mChildren)
		{
            String key = child.getName();
            ArrayList<Tag> group = groups.get(key);
            if(group == null)
			{
                group = new ArrayList<>();
                groups.put(key, group);
            }

            group.add(child);
        }

        return groups;
    }

    String getPath()
    {
        return mPath;
    }

    @NonNull
    @Override
    public String toString()
    {
        return "Tag: " + mName + ", " + mChildren.size() + " children, Content: " + mContent;
    }
}

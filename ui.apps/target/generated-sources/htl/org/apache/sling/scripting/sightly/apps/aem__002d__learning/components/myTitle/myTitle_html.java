/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.aem__002d__learning.components.myTitle;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class myTitle_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_template = null;
Object _global_model = null;
Object _global_mytitle = null;
Object _dynamic_currentstyle = bindings.get("currentstyle");
Object _dynamic_pageproperties = bindings.get("pageproperties");
_global_template = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_model = renderContext.call("use", com.adobe.aem.learning.core.models.MyTitleModel.class.getName(), obj());
_global_mytitle = renderContext.getObjectModel().resolveProperty(_global_model, "myTitle");
if (renderContext.getObjectModel().toBoolean(_global_mytitle)) {
    out.write("\n    <h1 class=\"cmp-my-title\">");
    {
        String var_0 = ("This is Model Title : " + renderContext.getObjectModel().toString(renderContext.call("xss", _global_mytitle, "text")));
        out.write(renderContext.getObjectModel().toString(var_0));
    }
    out.write("</h1>\n    <h2>");
    {
        String var_1 = ("Style System value : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_currentstyle, "type"), "text")));
        out.write(renderContext.getObjectModel().toString(var_1));
    }
    out.write("</h2>\n    <h3>Reading Page properties</h3>\n    <h4>");
    {
        String var_2 = ("Headline - " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_pageproperties, "headline"), "text")));
        out.write(renderContext.getObjectModel().toString(var_2));
    }
    out.write("</h4>\n    <h4>");
    {
        String var_3 = ("Prefix - " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_pageproperties, "prefix"), "text")));
        out.write(renderContext.getObjectModel().toString(var_3));
    }
    out.write("</h4>\n\n    ");
    {
        Object var_testvariable4 = renderContext.getObjectModel().resolveProperty(_global_model, "linkPath");
        if (renderContext.getObjectModel().toBoolean(var_testvariable4)) {
            out.write("<p>");
            {
                String var_5 = ("Link Path : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "linkPath"), "text")));
                out.write(renderContext.getObjectModel().toString(var_5));
            }
            out.write("</p>");
        }
    }
    out.write("\n    ");
    {
        Object var_testvariable6 = renderContext.getObjectModel().resolveProperty(_global_model, "external");
        if (renderContext.getObjectModel().toBoolean(var_testvariable6)) {
            out.write("<p>");
            {
                String var_7 = ("Target : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "target"), "text")));
                out.write(renderContext.getObjectModel().toString(var_7));
            }
            out.write("</p>");
        }
    }
    out.write("\n    ");
    {
        Object var_testvariable8 = renderContext.getObjectModel().resolveProperty(_global_model, "resourceType");
        if (renderContext.getObjectModel().toBoolean(var_testvariable8)) {
            out.write("<p>");
            {
                String var_9 = ("Resource Type : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "resourceType"), "text")));
                out.write(renderContext.getObjectModel().toString(var_9));
            }
            out.write("</p>");
        }
    }
    out.write("\n\n");
}
out.write("\n");
{
    Object var_templatevar10 = renderContext.getObjectModel().resolveProperty(_global_template, "placeholder");
    {
        boolean var_templateoptions11_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_mytitle));
        {
            String var_templateoptions11_field$_classappend = "cmp-title";
            {
                java.util.Map var_templateoptions11 = obj().with("isEmpty", var_templateoptions11_field$_isempty).with("classAppend", var_templateoptions11_field$_classappend);
                callUnit(out, renderContext, var_templatevar10, var_templateoptions11);
            }
        }
    }
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}


/*
 * Copyright 2002-2007,2009 The Apache Software Foundation.
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
package com.opensymphony.xwork2.ognl;

import com.opensymphony.xwork2.conversion.TypeConverter;

import java.lang.reflect.Member;
import java.util.Map;

/**
 * Wraps an XWork type conversion class for as an OGNL TypeConverter
 */
public class OgnlTypeConverterWrapper implements ognl.TypeConverter {

    private TypeConverter typeConverter;
    
    public OgnlTypeConverterWrapper(TypeConverter conv) {
        if (conv == null) {
            throw new IllegalArgumentException("Wrapped type converter cannot be null");
        }
        this.typeConverter = conv;
    }
    
    public Object convertValue(Map context, Object target, Member member,
            String propertyName, Object value, Class toType) {
        return typeConverter.convertValue(context, target, member, propertyName, value, toType);
    }
    
    public TypeConverter getTarget() {
        return typeConverter;
    }
}

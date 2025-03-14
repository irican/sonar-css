/*
 * SonarCSS
 * Copyright (C) 2018-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.css.plugin.rules;

import org.sonar.check.Rule;

import java.util.Arrays;
import java.util.List;

@Rule(key = "S4654")
public class PropertyNoUnknown implements CssRule {

  @Override
  public String stylelintKey() {
    return "property-no-unknown";
  }

  @Override
  public List<Object> stylelintOptions() {
    return Arrays.asList(true, new StylelintIgnoreOption());
  }

  private static class StylelintIgnoreOption {
    // Used by GSON serialization
    private final String[] ignoreProperties = {"composes", "exportedKey", "localAlias"};
  }
}

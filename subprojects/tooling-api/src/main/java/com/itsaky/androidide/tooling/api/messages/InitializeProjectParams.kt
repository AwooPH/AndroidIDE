/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.itsaky.androidide.tooling.api.messages

import java.io.Serializable

/**
 * Message sent from client to server to initialize the tooling API client in the given directory.
 *
 * @property directory The absolute path to the root directory of the project to initialize.
 * @property gradleInstallation The installation path of the Gradle distribution to use.
 * @property androidParams The [AndroidInitializationParams] for initializing the Android module projects.
 * @author Akash Yadav
 */
data class InitializeProjectParams @JvmOverloads constructor(
  val directory: String,
  val gradleInstallation: String = "",
  val androidParams: AndroidInitializationParams = AndroidInitializationParams.DEFAULT
) : Serializable

/**
 * Initialization params for Android project/modules.
 *
 * @property variantSelections The map of module paths to the name of the variants which should
 *            be fetched/initialized.
 */
data class AndroidInitializationParams(val variantSelections: Map<String, String>) : Serializable {

  companion object {

    /**
     * Default initialization params. This initializes the Android modules with default values.
     */
    @JvmStatic
    val DEFAULT = AndroidInitializationParams(emptyMap())
  }
}

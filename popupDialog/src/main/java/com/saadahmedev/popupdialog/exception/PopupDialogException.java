/*
 * Copyright 2018-2024 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedev.popupdialog.exception;

/**
 * Exception class to handle errors related to PopupDialog.
 * <p>
 * This exception class extends {@link RuntimeException} and is used to handle errors
 * specifically related to the PopupDialog functionality. It allows for custom error messages
 * to be provided when throwing instances of this exception.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public class PopupDialogException extends RuntimeException {

    /**
     * Constructs a new PopupDialogException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     */
    public PopupDialogException(String message) {
        super(message);
    }
}

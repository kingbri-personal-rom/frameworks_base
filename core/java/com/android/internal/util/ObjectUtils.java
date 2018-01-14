/*
 * Copyright (C) 2017 The Android Open Source Project
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


package com.android.internal.util;

import android.annotation.NonNull;
import android.annotation.Nullable;

/** @hide */
public class ObjectUtils {
    private ObjectUtils() {}

    @NonNull
    public static <T> T firstNotNull(@Nullable T a, @NonNull T b) {
        return a != null ? a : Preconditions.checkNotNull(b);
    }

    /**
     * Compares two {@link Nullable} objects with {@code null} values considered the smallest
     */
    public static <T extends Comparable> int compare(@Nullable T a, @Nullable T b) {
        if (a != null) {
            return (b != null) ? a.compareTo(b) : 1;
        } else {
            return (b != null) ? -1 : 0;
        }
    }

    /**
     * @return {@code null} if the given instance is not of the given calss, or the given
     *         instance otherwise
     */
    @Nullable
    public static <S, T extends S> T castOrNull(@Nullable S instance, @NonNull Class<T> c) {
        return c.isInstance(instance) ? (T) instance : null;
    }
}

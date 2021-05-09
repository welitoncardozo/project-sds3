import { format } from 'date-fns';

export const formatLocalDate = (value: any, pattern: string) => {
  const date = new Date(value);
  return format(
    new Date(date.valueOf() + date.getTimezoneOffset() * 60 * 1000),
    pattern
  );
}
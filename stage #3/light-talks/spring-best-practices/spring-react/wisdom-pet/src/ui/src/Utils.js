export function getCurrency(number) {
  const formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',});
  return formatter.format(number)
}
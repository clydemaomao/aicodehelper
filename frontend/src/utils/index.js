export function generateMemoryId() {
  return Math.floor(Date.now() % 1000000000)
}

export function formatTime(date) {
  const now = new Date()
  const diff = now - date

  if (diff < 60000) {
    return 'just now'
  }
  if (diff < 3600000) {
    return `${Math.floor(diff / 60000)} min ago`
  }
  if (diff < 86400000) {
    return `${Math.floor(diff / 3600000)} hr ago`
  }
  return date.toLocaleDateString()
}

export function debounce(func, wait) {
  let timeout
  return function executedFunction(...args) {
    const later = () => {
      clearTimeout(timeout)
      func(...args)
    }
    clearTimeout(timeout)
    timeout = setTimeout(later, wait)
  }
}
